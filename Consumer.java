package mitter.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Consumer {

	// start of the program for storing given key/value pairs in storeMap
	// instance

	public static void main(String[] args) throws IOException, ServerNotConnectedException, ServerStoreException,
			ServerGetException, ServerQueryException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Consumer consumer = new Consumer();
		consumer.mitterServerStore(br);
		br.close();
	}

	public void mitterServerStore(BufferedReader br) throws IOException, ServerNotConnectedException,
			ServerStoreException, ServerGetException, ServerQueryException {
		String s;
		s = br.readLine();
		char ch = s.charAt(0);
		if (ch == '>' && s.length() == 1) {
			System.out.println("Hello... You are online");
			OperationsImpl operations = new OperationsImpl();
			while (true) {
				String type = br.readLine();

				if (type.equals("store")) {   //checking the type of operation that user wants to perform
					String key = br.readLine();
					String value = br.readLine();
					if (operations.store(key, value))
						System.out.println("Success");
					else
						throw new ServerStoreException("Server insert issue");
				} else if (type.equals("get")) {
					String key;
					ArrayList<String> keys = new ArrayList<>();
					while ((key = br.readLine()) != null && key.length() != 0) {
						keys.add(key);
					}
					ArrayList<String> allValue = operations.get(keys);
					if (allValue == null || allValue.size() == 0)
						throw new ServerGetException("Server is unable to response query or key is not present");
					else
						System.out.println(allValue);
				} else if (type.equals("query")) {
					String key = br.readLine();
					if (operations.isNumber(key)) {
						ArrayList<Float> allFloat = operations.queryGt(key);
						if (allFloat == null || allFloat.size() == 0)
							throw new ServerQueryException("There is no value greater than given target ");
						else
							System.out.println(allFloat);

					} else {
						ArrayList<String> allString = operations.query(key);
						if (allString == null)
							throw new ServerQueryException("There is no value that matches given String ");
						else
							System.out.println(allString);
					}

				} else if (type.equals("<")) {
					System.out.println("you are disconnected from server...");
					System.exit(0);
				}
			}
		} else {
			throw new ServerNotConnectedException("For interaction to server fire first '>' command");
		}

	}

}
