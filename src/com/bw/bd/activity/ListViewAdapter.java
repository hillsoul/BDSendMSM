package com.bw.bd.activity;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.bd.send.R;

public class ListViewAdapter extends BaseAdapter {
	List<MessageEntity> mList;
	Context mContext;

	public ListViewAdapter(Context context, List<MessageEntity> mlistInfo) {
		mList = mlistInfo;
		mContext = context;
	}

	@Override
	public int getCount() {
		Log.i("yujin", "---getCount---");
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		Log.i("yujin", "---getItem---");
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		Log.i("yujin", "---getItemId---");
		// TODO Auto-generated method stub
		return mList.get(position)._id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		MessageEntity mReceivedMessage = mList.get(position);
		Holder h = null;
		if(convertView == null){
			h = new Holder();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
			h.header = (ImageView) convertView.findViewById(R.id.image_header);
			h.number = (TextView) convertView.findViewById(R.id.text_contacts);
			h.content = (TextView) convertView.findViewById(R.id.text_content);
			h.date = (TextView) convertView.findViewById(R.id.text_date);
			convertView.setTag(h);
		}else{
			h = (Holder)convertView.getTag();
		}
		h.header.setBackgroundResource(R.drawable.ic_contact_picture);
		h.number.setText(String.valueOf(mReceivedMessage.SndAddre));
		h.content.setText(mReceivedMessage.Msg);
		h.date.setText(mReceivedMessage.date);
		return convertView;
	}
	
	class Holder{
		ImageView header;
		TextView number;
		TextView content;
		TextView date;
	}
}
