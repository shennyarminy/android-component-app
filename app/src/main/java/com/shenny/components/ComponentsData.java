package com.shenny.components;

import java.util.ArrayList;

class ComponentsData {
    private static String[] componentNames = {
            "Activity",
            "Services",
            "Broadcast Receiver",
            "Content Provider",
    };

    private static String[] componentExplanation = {
            "\t\tSebuah activity menunjukan satu layar dengan user interface, singkatnya activity melakukan aksi pada layar. Oleh karena itu Activity selalu berjalan pada main thread."+
                    "\n\n\t\tKarena terdapat User Interface (UI), user dapat berinteraksi dengan activity tersebut seperti menekan tombol, scrolling, dll." +
                    "\n\n\t\tContohnya sebuah aplikasi pesan memiliki 2 activity yaitu:" +
                    "1. Activity yang menunjukan daftar pesan.\n" +
                    "2. Activity untuk membalas pesan tertentu.\n\n" +
                    "\t\tKarena activity bekerja pada main thread, tidak diperboleh melakukan proses yang dapat menunda atau memblokir main thread seperti network request atau membaca file. Hal tersebut dapat menyebabkan perlambatan respon dari activity terhadap user dan mengurangi fps (frame per second) < 60 fps ( 60 fps merupakan rekomendasi Google agar interaksi antara user dan aplikasi terlihat mulus/smooth ). Skenario paling parah aplikasi kalian akan dianggap not responding oleh android dan user terpaksa harus menutup paksa (force close) aplikasi kalian."+
                    "\n\n\t\tActivity diaktifkan oleh pesan asinkron yang disebut intent. Intent mengikat antar masing-masing komponen di runtime. Intent dapat diumpamakan sebagai messenger yang meminta tindakan dari komponen lain, entah komponen milik aplikasi Anda atau komponen lainnya."+
                    "\n\n\t\tIntent dibuat dengan objek Intent, yang mendefinisikan pesan untuk mengaktifkan komponen tertentu (intent ekspolisit) atau tipe komponen spesifik (intent implisit)."+
                    "\n\n\t\tUntuk Activity dan Service, intent mendefinisikan aksi yang akan dilakukan (misalnya, untuk melihat atau mengirim sesuatu) dan mungkin menetapkan URI data untuk ditindaklanjuti, salah satu hal yang mungkin perlu diketahui oleh komponen yang akan dimulai."+
                    "\n\n\t\tActivity harus di daftarkan pada android manifes dengan elemen <activity>.",

            "\t\tSama seperti Activity hanya saja Service tidak memiliki UI sehingga user tidak dapat berinteraksi dengan service.\n\n\t\tBerbeda dengan Activity jika aplikasi ditutup oleh user maka Activity juka akan berhenti, Service akan tetap berjalan meskipun aplikasi telah ditutup oleh user. Service berjalan di main thread pada Activity yang memulainya, kita harus membuat background threadnya sendiri untuk melakukan proses yang berat.\n\n" +
                    "\t\tPada Service ini kalian dapat melakukan aksi seperti network request, memainkan musik, melakukan sync database pada cloud, ataupun menampilkan notifikasi."+
                    "\n\n\t\tService juga dapat di aktifkan menggunakan intent sama seperti Activity."+
                    "\n\n\t\tService harus di daftarkan pada android manifes dengan elemen <service>.",

            "\t\tBroadcast Receiver sederhananya merupakan komponen android yang menerima pesan broadcast dari aplikasi lain atau dari sistem Android itu sendiri.\n\n" +
                    "\t\tContoh sebuah aplikasi mengirimkan pesan broadcast bahwa aplikasi tersebut ingin mengirimkan email, maka aplikasi yang memiliki Broadcast Receivers untuk menangani pengiriman email seperti Gmail akan dapat memproses permintaan tersebut.\n\n" +
                    "\t\tContoh lainnya sebuah aplikasi wisata mengirimkan pesan broadcast untuk menunjukan lokasi yang diklik oleh user dan ditampilkan pada map. Aplikasi yang memiliki Broadcast Receiver untuk menangani permintaan tersebut seperti Google Maps akan dapat menanganinya.\n\n"+
                    "\t\tWalaupun Broadcast Receiver tidak menampilkan antarmuka pengguna, Broadcast Receiver dapat membuat notifikasi bilah status untuk memberi tahu pengguna kapan kejadian siaran dilakukan. \n\n\t\tMeskipun Broadcast Receiver umumnya cuma menjadi gerbang untuk komponen lain dan dimaksudkan untuk melakukan pekerjaan dalam jumlah sangat minim. Misalnya, mungkin dijadwalkan JobService melakukan beberapa pekerjaan berdasarkan acara dengan JobScheduler."+
                    "\n\n\t\tBroadcast Receiver dapat diaktifkan menggunakan intent. Namun berbeda dengan Activity dan Services, untuk Broadcast Receiver, intent hanya mendefinisikan pengumuman yang sedang disiarkan. Misalnya, siaran untuk menunjukkan baterai perangkat hampir habis hanya menyertakan string tindakan yang menunjukkan baterai hampir habis."+
                    "\n\n\t\tBroadcast Receiver harus di daftarkan pada android manifes dengan elemen <receiver>.",

            "\t\tContent Providers merupakan komponen Android yang membantu mengakses data pada Android seperti database. Content Provider juga dapat digunakan untuk mengakses data pada aplikasi lain jika aplikasi tersebut mengijinkan dan kalian juga dapat share data aplikasi kalian. Content Provider biasa disebut sebagai Abstraction Layer antara layer aplikasi dan layer data. "+
                    "\n\n\t\tPenyedia materi mengelola set data aplikasi secara bersama-sama, yang dapat Anda simpan di sistem file, di database SQLite, di web, atau di lokasi penyimpanan persisten lain yang dapat diakses oleh aplikasi Anda."+
                    "\n\n\t\tContent Provider memiliki beragam tujuan inti untuk perspektif desain-sistem. Bagi sistem, Content Provider adalah titik masuk ke dalam suatu aplikasi untuk memublikasikan item data bernama, yang diidentifikasi oleh skema URI. Jadi sebuah aplikasi dapat memutuskan bagaimana ia ingin memetakan data yang ada di dalamnya ke ruang nama URI, membagikan URI tersebut ke entitas lain yang dapat menggunakannya guna mengakses data."+
                    "\n\n\t\tTidak seperti Activity, Services, dan Broadcast Receiver, Content Provider tidak diaktifkan oleh intent. Melainkan, diaktifkan saat ditargetkan oleh permintaan dari ContentResolver. ContentResolver menangani semua transaksi langsung dengan penyedia konten sehingga komponen yang melakukan transaksi dengan penyedia tidak perlu dan sebagai gantinya memanggil metode pada objek ContentResolver. Ini membuat layer abstraksi antara penyedia konten dan komponen yang meminta informasi (demi keamanan)."+
                    "\n\n\t\tContent Provider harus di daftarkan pada android manifes dengan elemen <provider>."
    };

    private static int[] componentIcon = {
            R.drawable.activity,
            R.drawable.services,
            R.drawable.broadcast_receiver,
            R.drawable.content_provider,
    };

    private static String[] componentExampleCode = {
            " Package com.example.helloworld;\n" +
                    "\n" +
                    "import android.os.Bundle;\n" +
                    "import android.app.Activity;\n" +
                    "import android.util.Log;\n" +
                    "\n" +
                    "public class MainActivity extends Activity {\n" +
                    "   String msg = \"Android : \";\n" +
                    "   \n" +
                    "   /** Called when the activity is first created. */\n" +
                    "   @Override\n" +
                    "   public void onCreate(Bundle savedInstanceState) {\n" +
                    "      super.onCreate(savedInstanceState);\n" +
                    "      setContentView(R.layout.activity_main);\n" +
                    "      Log.d(msg, \"The onCreate() event\");\n" +
                    "   }\n" +
                    "\n" +
                    "   /** Called when the activity is about to become visible. */\n" +
                    "   @Override\n" +
                    "   protected void onStart() {\n" +
                    "      super.onStart();\n" +
                    "      Log.d(msg, \"The onStart() event\");\n" +
                    "   }\n" +
                    "\n" +
                    "   /** Called when the activity has become visible. */\n" +
                    "   @Override\n" +
                    "   protected void onResume() {\n" +
                    "      super.onResume();\n" +
                    "      Log.d(msg, \"The onResume() event\");\n" +
                    "   }\n" +
                    "\n" +
                    "   /** Called when another activity is taking focus. */\n" +
                    "   @Override\n" +
                    "   protected void onPause() {\n" +
                    "      super.onPause();\n" +
                    "      Log.d(msg, \"The onPause() event\");\n" +
                    "   }\n" +
                    "\n" +
                    "   /** Called when the activity is no longer visible. */\n" +
                    "   @Override\n" +
                    "   protected void onStop() {\n" +
                    "      super.onStop();\n" +
                    "      Log.d(msg, \"The onStop() event\");\n" +
                    "   }\n" +
                    "\n" +
                    "   /** Called just before the activity is destroyed. */\n" +
                    "   @Override\n" +
                    "   public void onDestroy() {\n" +
                    "      super.onDestroy();\n" +
                    "      Log.d(msg, \"The onDestroy() event\");\n" +
                    "   }\n" +
                    "}",

            "Package com.tutorialspoint;\n" +
                    "\n" +
                    "import android.app.Service;\n" +
                    "import android.os.IBinder;\n" +
                    "import android.content.Intent;\n" +
                    "import android.os.Bundle;\n" +
                    "\n" +
                    "public class HelloService extends Service {\n" +
                    "   \n" +
                    "   /** indicates how to behave if the service is killed */\n" +
                    "   int mStartMode;\n" +
                    "   \n" +
                    "   /** interface for clients that bind */\n" +
                    "   IBinder mBinder;     \n" +
                    "   \n" +
                    "   /** indicates whether onRebind should be used */\n" +
                    "   boolean mAllowRebind;\n" +
                    "\n" +
                    "   /** Called when the service is being created. */\n" +
                    "   @Override\n" +
                    "   public void onCreate() {\n" +
                    "     \n" +
                    "   }\n" +
                    "\n" +
                    "   /** The service is starting, due to a call to startService() */\n" +
                    "   @Override\n" +
                    "   public int onStartCommand(Intent intent, int flags, int startId) {\n" +
                    "      return mStartMode;\n" +
                    "   }\n" +
                    "\n" +
                    "   /** A client is binding to the service with bindService() */\n" +
                    "   @Override\n" +
                    "   public IBinder onBind(Intent intent) {\n" +
                    "      return mBinder;\n" +
                    "   }\n" +
                    "\n" +
                    "   /** Called when all clients have unbound with unbindService() */\n" +
                    "   @Override\n" +
                    "   public boolean onUnbind(Intent intent) {\n" +
                    "      return mAllowRebind;\n" +
                    "   }\n" +
                    "\n" +
                    "   /** Called when a client is binding to the service with bindService()*/\n" +
                    "   @Override\n" +
                    "   public void onRebind(Intent intent) {\n" +
                    "\n" +
                    "   }\n" +
                    "\n" +
                    "   /** Called when The service is no longer used and is being destroyed */\n" +
                    "   @Override\n" +
                    "   public void onDestroy() {\n" +
                    "\n" +
                    "   }\n" +
                    "}",
            "package com.example.tutorialspoint7.myapplication;\n" +
                    "\n" +
                    "import android.content.BroadcastReceiver;\n" +
                    "import android.content.Context;\n" +
                    "import android.content.Intent;\n" +
                    "import android.widget.Toast;\n" +
                    "\n" +
                    "/**\n" +
                    " * Created by TutorialsPoint7 on 8/23/2016.\n" +
                    " */\n" +
                    "public class MyReceiver extends BroadcastReceiver{\n" +
                    "   @Override\n" +
                    "   public void onReceive(Context context, Intent intent) {\n" +
                    "      Toast.makeText(context, \"Intent Detected.\", Toast.LENGTH_LONG).show();\n" +
                    "   }\n" +
                    "}",

             "package com.example.MyApplication;\n" +
                    "\n" +
                    "import java.util.HashMap;\n" +
                    "\n" +
                    "import android.content.ContentProvider;\n" +
                    "import android.content.ContentUris;\n" +
                    "import android.content.ContentValues;\n" +
                    "import android.content.Context;\n" +
                    "import android.content.UriMatcher;\n" +
                    "\n" +
                    "import android.database.Cursor;\n" +
                    "import android.database.SQLException;\n" +
                    "\n" +
                    "import android.database.sqlite.SQLiteDatabase;\n" +
                    "import android.database.sqlite.SQLiteOpenHelper;\n" +
                    "import android.database.sqlite.SQLiteQueryBuilder;\n" +
                    "\n" +
                    "import android.net.Uri;\n" +
                    "import android.text.TextUtils;\n" +
                    "\n" +
                    "public class StudentsProvider extends ContentProvider {\n" +
                    "   static final String PROVIDER_NAME = \"com.example.MyApplication.StudentsProvider\";\n" +
                    "   static final String URL = \"content://\" + PROVIDER_NAME + \"/students\";\n" +
                    "   static final Uri CONTENT_URI = Uri.parse(URL);\n" +
                    "\n" +
                    "   static final String _ID = \"_id\";\n" +
                    "   static final String NAME = \"name\";\n" +
                    "   static final String GRADE = \"grade\";\n" +
                    "\n" +
                    "   private static HashMap<String, String> STUDENTS_PROJECTION_MAP;\n" +
                    "\n" +
                    "   static final int STUDENTS = 1;\n" +
                    "   static final int STUDENT_ID = 2;\n" +
                    "\n" +
                    "   static final UriMatcher uriMatcher;\n" +
                    "   static{\n" +
                    "      uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);\n" +
                    "      uriMatcher.addURI(PROVIDER_NAME, \"students\", STUDENTS);\n" +
                    "      uriMatcher.addURI(PROVIDER_NAME, \"students/#\", STUDENT_ID);\n" +
                    "   }\n" +
                    "\n" +
                    "   /**\n" +
                    "      * Database specific constant declarations\n" +
                    "   */\n" +
                    "   \n" +
                    "   private SQLiteDatabase db;\n" +
                    "   static final String DATABASE_NAME = \"College\";\n" +
                    "   static final String STUDENTS_TABLE_NAME = \"students\";\n" +
                    "   static final int DATABASE_VERSION = 1;\n" +
                    "   static final String CREATE_DB_TABLE =\n" +
                    "      \" CREATE TABLE \" + STUDENTS_TABLE_NAME +\n" +
                    "         \" (_id INTEGER PRIMARY KEY AUTOINCREMENT, \" +\n" +
                    "         \" name TEXT NOT NULL, \" +\n" +
                    "         \" grade TEXT NOT NULL);\";\n" +
                    "\n" +
                    "   /**\n" +
                    "      * Helper class that actually creates and manages\n" +
                    "      * the provider's underlying data repository.\n" +
                    "   */\n" +
                    "   \n" +
                    "   private static class DatabaseHelper extends SQLiteOpenHelper {\n" +
                    "      DatabaseHelper(Context context){\n" +
                    "         super(context, DATABASE_NAME, null, DATABASE_VERSION);\n" +
                    "      }\n" +
                    "\n" +
                    "      @Override\n" +
                    "      public void onCreate(SQLiteDatabase db) {\n" +
                    "         db.execSQL(CREATE_DB_TABLE);\n" +
                    "      }\n" +
                    "\n" +
                    "      @Override\n" +
                    "      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {\n" +
                    "         db.execSQL(\"DROP TABLE IF EXISTS \" +  STUDENTS_TABLE_NAME);\n" +
                    "         onCreate(db);\n" +
                    "      }\n" +
                    "   }\n" +
                    "\n" +
                    "   @Override\n" +
                    "   public boolean onCreate() {\n" +
                    "      Context context = getContext();\n" +
                    "      DatabaseHelper dbHelper = new DatabaseHelper(context);\n" +
                    "\n" +
                    "      /**\n" +
                    "         * Create a write able database which will trigger its\n" +
                    "         * creation if it doesn't already exist.\n" +
                    "      */\n" +
                    "         \n" +
                    "      db = dbHelper.getWritableDatabase();\n" +
                    "      return (db == null)? false:true;\n" +
                    "   }\n" +
                    "\n" +
                    "   @Override\n" +
                    "   public Uri insert(Uri uri, ContentValues values) {\n" +
                    "      /**\n" +
                    "         * Add a new student record\n" +
                    "      */\n" +
                    "      long rowID = db.insert(   STUDENTS_TABLE_NAME, \"\", values);\n" +
                    "\n" +
                    "      /**\n" +
                    "         * If record is added successfully\n" +
                    "      */\n" +
                    "      if (rowID > 0) {\n" +
                    "         Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);\n" +
                    "         getContext().getContentResolver().notifyChange(_uri, null);\n" +
                    "         return _uri;\n" +
                    "      }\n" +
                    "        \n" +
                    "      throw new SQLException(\"Failed to add a record into \" + uri);\n" +
                    "   }\n" +
                    "\n" +
                    "   @Override\n" +
                    "   public Cursor query(Uri uri, String[] projection, \n" +
                    "      String selection,String[] selectionArgs, String sortOrder) {\n" +
                    "      SQLiteQueryBuilder qb = new SQLiteQueryBuilder();\n" +
                    "      qb.setTables(STUDENTS_TABLE_NAME);\n" +
                    "\n" +
                    "      switch (uriMatcher.match(uri)) {\n" +
                    "         case STUDENTS:\n" +
                    "            qb.setProjectionMap(STUDENTS_PROJECTION_MAP);\n" +
                    "         break;\n" +
                    "\n" +
                    "         case STUDENT_ID:\n" +
                    "            qb.appendWhere( _ID + \"=\" + uri.getPathSegments().get(1));\n" +
                    "         break;\n" +
                    "         \n" +
                    "         default:   \n" +
                    "      }\n" +
                    "\n" +
                    "      if (sortOrder == null || sortOrder == \"\"){\n" +
                    "         /**\n" +
                    "            * By default sort on student names\n" +
                    "         */\n" +
                    "         sortOrder = NAME;\n" +
                    "      }\n" +
                    "      \n" +
                    "      Cursor c = qb.query(db,   projection, selection, \n" +
                    "         selectionArgs,null, null, sortOrder);\n" +
                    "      /**\n" +
                    "         * register to watch a content URI for changes\n" +
                    "      */\n" +
                    "      c.setNotificationUri(getContext().getContentResolver(), uri);\n" +
                    "      return c;\n" +
                    "   }\n" +
                    "\n" +
                    "   @Override\n" +
                    "   public int delete(Uri uri, String selection, String[] selectionArgs) {\n" +
                    "      int count = 0;\n" +
                    "      switch (uriMatcher.match(uri)){\n" +
                    "         case STUDENTS:\n" +
                    "            count = db.delete(STUDENTS_TABLE_NAME, selection, selectionArgs);\n" +
                    "         break;\n" +
                    "\n" +
                    "         case STUDENT_ID:\n" +
                    "            String id = uri.getPathSegments().get(1);\n" +
                    "            count = db.delete( STUDENTS_TABLE_NAME, _ID +  \" = \" + id +\n" +
                    "               (!TextUtils.isEmpty(selection) ? \" \n" +
                    "               AND (\" + selection + ')' : \"\"), selectionArgs);\n" +
                    "            break;\n" +
                    "         default:\n" +
                    "            throw new IllegalArgumentException(\"Unknown URI \" + uri);\n" +
                    "      }\n" +
                    "\n" +
                    "      getContext().getContentResolver().notifyChange(uri, null);\n" +
                    "      return count;\n" +
                    "   }\n" +
                    "\n" +
                    "   @Override\n" +
                    "   public int update(Uri uri, ContentValues values, \n" +
                    "      String selection, String[] selectionArgs) {\n" +
                    "      int count = 0;\n" +
                    "      switch (uriMatcher.match(uri)) {\n" +
                    "         case STUDENTS:\n" +
                    "            count = db.update(STUDENTS_TABLE_NAME, values, selection, selectionArgs);\n" +
                    "         break;\n" +
                    "\n" +
                    "         case STUDENT_ID:\n" +
                    "            count = db.update(STUDENTS_TABLE_NAME, values, \n" +
                    "               _ID + \" = \" + uri.getPathSegments().get(1) +\n" +
                    "               (!TextUtils.isEmpty(selection) ? \" \n" +
                    "               AND (\" +selection + ')' : \"\"), selectionArgs);\n" +
                    "            break;\n" +
                    "         default:\n" +
                    "            throw new IllegalArgumentException(\"Unknown URI \" + uri );\n" +
                    "      }\n" +
                    "        \n" +
                    "      getContext().getContentResolver().notifyChange(uri, null);\n" +
                    "      return count;\n" +
                    "   }\n" +
                    "\n" +
                    "   @Override\n" +
                    "   public String getType(Uri uri) {\n" +
                    "      switch (uriMatcher.match(uri)){\n" +
                    "         /**\n" +
                    "            * Get all student records\n" +
                    "         */\n" +
                    "         case STUDENTS:\n" +
                    "            return \"vnd.android.cursor.dir/vnd.example.students\";\n" +
                    "         /**\n" +
                    "            * Get a particular student\n" +
                    "         */\n" +
                    "         case STUDENT_ID:\n" +
                    "            return \"vnd.android.cursor.item/vnd.example.students\";\n" +
                    "         default:\n" +
                    "            throw new IllegalArgumentException(\"Unsupported URI: \" + uri);\n" +
                    "      }\n" +
                    "   }\n" +
                    "}"
    };

    private static String[] componentURLs = {
            "https://developer.android.com/guide/components/activities",
            "https://developer.android.com/guide/components/services.html",
            "https://developer.android.com/reference/android/content/BroadcastReceiver?hl=en",
            "https://developer.android.com/guide/topics/providers/content-providers?hl=en"
    };

    static ArrayList<Component> getListData(){
        ArrayList<Component> list = new ArrayList<>();
        for (int position = 0; position < componentNames.length ; position++){
            Component component = new Component();
            component.setName(componentNames[position]);
            component.setDetail(componentExplanation[position]);
            component.setPhoto(componentIcon[position]);
            component.setURL(componentURLs[position]);
            component.setExampleCode(componentExampleCode[position]);
            list.add(component);
        }
        return list;
    }
}

