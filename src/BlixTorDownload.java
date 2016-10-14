import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;

import com.turn.ttorrent.client.Client;
import com.turn.ttorrent.client.SharedTorrent;

public class BlixTorDownload {
	private static final double noUploadRate = Double.MIN_VALUE;
	
	public static String browseTorrentFile = "";
	public static String downloadLocation = "";
	
	public static double downloadRate = 0;
	public static double uploadRate = 0;
	public static int seedTime = 0;
	
	public static void DownloadTorrent() throws UnknownHostException, IOException, NoSuchAlgorithmException {
		Client client = new Client(
				InetAddress.getLocalHost(),

				SharedTorrent.fromFile(
						new File(browseTorrentFile),
						new File(downloadLocation)
				)
		);
		
		client.setMaxDownloadRate(downloadRate);
		client.setMaxUploadRate(noUploadRate);
		
		client.download();
		
		client.share(seedTime);
		
		client.waitForCompletion();
	}
}
