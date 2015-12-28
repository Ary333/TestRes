package com.paresh.gridviewexample;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

@SuppressWarnings("deprecation")
@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class GridViewExampleActivity123 extends Activity {
	/** Called when the activity is first created. */

	private GridviewAdapter mAdapter;
	private ArrayList<String> listCountry;
	private ArrayList<String> listimg;
	private ArrayList<Integer> listFlag;

	private GridView gridView;
	public static int level=1;
	int page=1;
	Animation  animZoomIn;
	Button button;
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exa); 

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
		.permitAll().build();
StrictMode.setThreadPolicy(policy);

//Set custom adapter to gridview
		gridView = (GridView) findViewById(R.id.gridView1);

		prepareList();
		gridView.setAdapter(mAdapter);

		// Implement On Item click listener
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				GridViewExampleActivity123.level++; 
//				Toast.makeText(GridViewExampleActivity.this,
//						"Level: "+GridViewExampleActivity1.level, Toast.LENGTH_SHORT).show(); 
//				startActivity(new Intent(GridViewExampleActivity.this,GridViewExampleActivity.class));
				/*Toast.makeText(GridViewExampleActivity.this,
						mAdapter.getItem(position), Toast.LENGTH_SHORT).show();*/
			}
		});
		
		/*button=(Button)findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) { 
				
				startActivity(new Intent(GridViewExampleActivity1.this,GridViewExampleActivity.class));
			}
		});*/
	}

	public void prepareList() {
    	 	
  		if (page == 1) {
			
   			listCountry = new ArrayList<String>();
			listimg = new ArrayList<String>();
			listFlag = new ArrayList<Integer>();
		}
   
			listCountry.add("india");
			listCountry.add("Brazil");
			listCountry.add("Apple Watch 42mm Space Gray Aluminum C");
			listCountry.add("China");
			listCountry.add("France");
			listCountry.add("Germany");
			
//			String url="http://stg.incentiveweb.com//images/libertymutualtheirsite.gif";
			
			listimg.add("https://upload.wikimedia.org/wikipedia/en/b/bc/Torus_with_cross-hatched_wireframe.gif");
			listimg.add("http://f.tqn.com/y/graphicssoft/1/S/n/p/5/ST_animated_turkey01.gif");
			listimg.add("https://upload.wikimedia.org/wikipedia/en/b/bc/Torus_with_cross-hatched_wireframe.gif");
			listimg.add("http://f.tqn.com/y/graphicssoft/1/S/n/p/5/ST_animated_turkey01.gif");
			listimg.add("http://f.tqn.com/y/graphicssoft/1/S/n/p/5/ST_animated_turkey01.gif");
			listimg.add("http://www.small-world.net/_borders/small_world_logo.gif");
//		
//			listCountry.add("Iran");
//			listCountry.add("Italy");
//			listCountry.add("Japan");
//			listCountry.add("Korea");
//			listCountry.add("Mexico");
//			listCountry.add("Netherlands");
//			listCountry.add("Portugal");
//			listCountry.add("Russia");
//			listCountry.add("Saudi Arabia");
//			listCountry.add("Spain");
//			listCountry.add("Turkey");
//			listCountry.add("United Kingdom" + page);
		// listCountry.add("United States");
 
		listFlag.add(R.drawable.india);
		listFlag.add(R.drawable.brazil);
		listFlag.add(R.drawable.canada);
		listFlag.add(R.drawable.china);
		listFlag.add(R.drawable.france);
		listFlag.add(R.drawable.germany);
//		listFlag.add(R.drawable.iran);
//		listFlag.add(R.drawable.italy);
//		listFlag.add(R.drawable.japan);
//		listFlag.add(R.drawable.korea);
//		listFlag.add(R.drawable.mexico);
//		listFlag.add(R.drawable.netherlands);
//		listFlag.add(R.drawable.portugal);
//		listFlag.add(R.drawable.russia);
//		listFlag.add(R.drawable.saudi_arabia);
//		listFlag.add(R.drawable.spain);
//		listFlag.add(R.drawable.turkey);
//		listFlag.add(R.drawable.united_kingdom);
		// listFlag.add(R.drawable.united_states);

		// currentPosition = currentPosition * 2;
		// System.out.println("value" +
		// gridView.getFirstVisiblePosition()+":"+currentPosition +":"+
		// listFlag.size()+":"+gridView.getCount());
		if (page == 1) {
			mAdapter = new GridviewAdapter(this, listCountry, listFlag);
			gridView.setAdapter(mAdapter);
		} else {

			int currentPosition = gridView.getFirstVisiblePosition();
 
			System.out.println("value" + currentPosition + ":"
					+ listFlag.size());
			gridView.setSelection(currentPosition + 4);
		}
	}

	@SuppressLint("InflateParams")
	public class GridviewAdapter extends BaseAdapter {
		private ArrayList<String> listCountry;
		@SuppressWarnings("unused")
		private ArrayList<Integer> listFlag; 
		private Activity activity;

		public GridviewAdapter(Activity activity,
				ArrayList<String> listCountry, ArrayList<Integer> listFlag) {
			super();
			this.listCountry = listCountry;
			this.listFlag = listFlag;
			this.activity = activity;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return listCountry.size();
		}

		@Override
		public String getItem(int position) {
			// TODO Auto-generated method stub
			return listCountry.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder view;
			LayoutInflater inflator = activity.getLayoutInflater();
			System.out.println("position" + position + ":" + (getCount() - 1));
			if (position == getCount() - 1) {

				/*Toast.makeText(GridViewExampleActivity.this, "page" + page,
						Toast.LENGTH_LONG).show();*/
				// if(page==1){
				page++;
				prepareList();
			
				// }else{
				//
				//
				// new Thread(new Runnable() {
				// public void run() {
				// try {
				//
				// Thread.sleep(2000);
				// } catch (Exception e) {
				// e.printStackTrace();
				// } finally {
				// prepareList();
				// page++;
				// }
				// }
				// });
				// }

			}

			if (convertView == null) {
				view = new ViewHolder();
				convertView = inflator.inflate(R.layout.gridview_row, null);

				view.txtViewTitle = (TextView) convertView
						.findViewById(R.id.textView1);
				view.imgViewFlag = (ImageView) convertView
						.findViewById(R.id.imageView1);
  
//				view.imgViewFlag.startAnimation(animZoomIn);
				
				convertView.setTag(view);
			} else {
				view = (ViewHolder) convertView.getTag();

			}

			view.txtViewTitle.setText(listCountry.get(position));
//			view.imgViewFlag.setImageResource(listFlag.get(position));
//			view.imgViewFlag.setImageBitmap(getBitmap(listimg.get(position)));
//			Picasso.with(GridViewExampleActivity1.this).load((""+).into(view.imgViewFlag);

			Picasso.with(getApplicationContext())
			.load(listimg.get(position))
			.placeholder(R.drawable.icon)
			.error(R.drawable.icon).fit().into(view.imgViewFlag);
			
			return convertView;
		}

	}

	public static class ViewHolder {
		public ImageView imgViewFlag;
		public TextView txtViewTitle;
	}
	
	 public Bitmap getBitmap(String url) {    //pass the complete URL of the web service query
	        Bitmap bmp = null;
	        try {
	            HttpClient client = new DefaultHttpClient();
	            URI imageURI = new URI(url);
	            HttpGet req = new HttpGet();
	            req.setURI(imageURI);
	           HttpResponse response = client.execute(req);
	            bmp = BitmapFactory.decodeStream(response.getEntity().getContent());    //BitmapFactory decodes the InputStream of the HttpResponse
	       } catch (URISyntaxException e) {        //catch those exceptions
	           Log.e("ERROR",e.getMessage());
	       } catch (ClientProtocolException e) {
	           Log.e("ERROR",e.getMessage());
	       } catch (IllegalStateException e) {
	           Log.e("ERROR",e.getMessage());
	      } catch (IOException e) {
	           Log.e("ERROR",e.getMessage());
	       }catch (NullPointerException e) {
	           Log.e("ERROR",e.getMessage());
	       }
	       return bmp;
	   }
}