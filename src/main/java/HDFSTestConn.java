import org.apache.hadoop.fs.*;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;


public class HDFSTestConn {

    public static void main (String [] args) throws Exception{
        try{
            Vector vector = new Vector();
            Configuration cfg = new Configuration();
            cfg.set("fs.default.name","hdfs://75.73.199.231:9000");
            cfg.set("mapred.job.tracker","75.73.199.231:9001");
            FileSystem fs = FileSystem.get(cfg);
            Path pt = new Path("/sample1/WordcountInput.txt");
            System.out.println(pt.getName());
            System.out.println(fs.exists(pt));
            BufferedReader br=new BufferedReader(new InputStreamReader(fs.open(pt)));
            String line;
            line=br.readLine();
            while (line != null){
                System.out.println(line);
                line=br.readLine();
            }

        }catch (Exception e){
            System.out.print(e);
        }
    }
}
