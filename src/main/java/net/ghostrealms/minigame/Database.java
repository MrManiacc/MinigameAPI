package net.ghostrealms.minigame;

/**
 * Created by James on 8/6/2015.
 */
public class Database {
   enum SQL {
        H2,
        MYSQL,
        SQLITE;
    }

    private final JavaPlugin plugin;
    private final String db;

    private SQL mode = SQL.H2;

    private Connection connection;

    private String mysql_user, mysql_pass, mysql_host, mysql_database;

    private int mysql_port;

    private String url;

    private ArrayList<String> updateQueue = new ArrayList<String>();

    public Database(String db, JavaPlugin plugin) {
        this.db = db;
        this.plugin = plugin;

        if (mode == SQL.MYSQL) {
            FileConfiguration config = plugin.getConfig();
            mysql_database = config.getString("database.name");
            mysql_host = config.getString("database.host");
            mysql_user = config.getString("database.user");
            mysql_pass = config.getString("database.pass");
            mysql_port = config.getInt("database.port");
        }

        setupConnection();
    }

    private void setupConnection() {

        switch (mode) {
            default:
            case H2:
                try {
                    Class.forName("org.h2.Driver");
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    this.setConnection(null);
                    break;
                }

                this.setURL("jdbc:h2:" + plugin.getDataFolder() + File.separator + db);

                try {
                    this.setConnection(DriverManager.getConnection(url));
                } catch (SQLException ex) {
                    this.setConnection(null);
                    ex.printStackTrace();
                }
                break;
            case MYSQL:
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    this.setConnection(null);
                    break;
                }

                try {
                    this.setURL("jdbc:mysql://" + mysql_host + ":" + mysql_port + "/" + mysql_database);
                    this.setConnection(DriverManager.getConnection(getURL(), mysql_user, mysql_pass));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    this.setConnection(null);
                    break;
                }
                break;
            case SQLITE:
                try {
                    Class.forName("org.sqlite.JDBC");
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    this.setConnection(null);
                    break;
                }

                try {
                    this.setConnection(DriverManager.getConnection("jdbc:sqlite:" + plugin.getDataFolder() +
                            File.separator + db));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    this.setConnection(null);
                    break;
                }
                break;
        }

    }

    protected void flush() {
        forceRunQueue();
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.setConnection(null);
        }
    }

    /**
     * This will add an Update SQL statement to the queue to be updated upon calling
     * #forceRunQueue*
     */
    public void queue(String statement) {
        updateQueue.add(statement);
    }

    public void forceRunQueue() {
        for (String sql : updateQueue) {
            update(sql);
            updateQueue.remove(sql);
        }
    }

    public boolean execute(String sql) {
        try {
            Statement stmt = connection.createStatement();
            boolean result = stmt.execute(sql);
            stmt.closeOnCompletion();
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public int executeUpdate(String sql) {
        try {
            Statement stmt = connection.createStatement();
            int status = stmt.executeUpdate(sql);
            stmt.closeOnCompletion();
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet status = stmt.executeQuery(sql);
            stmt.closeOnCompletion();
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ResultSet query(String sql) {
        return executeQuery(sql);
    }

    public int update(String sql) {
        return executeUpdate(sql);
    }

    public SQL getMode() {
        return mode;
    }

    protected void setMode(SQL mode) {
        this.mode = mode;
    }

    public Connection getConnection() {
        return connection;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getURL() {
        return url;
    }

    protected void setURL(String url) {
        this.url = url;
    }
}
