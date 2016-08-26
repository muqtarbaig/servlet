package org.sample.couchbase;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.couchbase.client.CouchbaseClient;
import com.couchbase.client.protocol.views.Query;
import com.couchbase.client.protocol.views.Stale;
import com.couchbase.client.protocol.views.View;
import com.couchbase.client.protocol.views.ViewResponse;
import com.couchbase.client.protocol.views.ViewRow;

public class ViewTest {

	CouchbaseClient client = null;
	
	private CouchbaseClient getClient() {
		System.out.println("Get client");
		if(null == client) {
			 URI local;
			try {
				String host =  "127.0.0.1";
				local = new URI("http://" + host + ":8091/pools");
				List<URI> baseURIs=new ArrayList<URI>();
			    baseURIs.add(local);
			return new CouchbaseClient(baseURIs,"pgauth_accounts_notifications","");
			} catch (URISyntaxException | IOException e) {
				e.printStackTrace();
			}
		}
		return client;
	}
	
	private void runView() throws InterruptedException, ExecutionException {
		System.out.println("Run view");
		CouchbaseClient client = getClient();
		System.out.println("Get view");
		View view = client.getView("SD_SESSION_CLEANUP_DOC", "SD_SESSION_CLEANUP_VIEW");
		Query query = new Query();
		query.setStale(Stale.UPDATE_AFTER);

		System.out.println("start query");
		ViewResponse response = client.query(view, query);
		System.out.println("Start iterator");
		Iterator<ViewRow> respIterator = response.iterator();
		while(respIterator.hasNext()) {
			ViewRow v = respIterator.next();
			System.out.println("ID "+v.getId());
		}
		
		client.shutdown();
	}
	
	public static void main(String[] args) {
		ViewTest test = new ViewTest();
		try {
			test.runView();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
