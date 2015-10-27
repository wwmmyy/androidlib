package com.lidroid.xutils.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
/**
 * http://blog.csdn.net/lmj623565791/article/details/38902805
* @类名: CommonAdapter 
* @描述: TODO 
* @作者: 王明远 
* @日期: 2015-5-28 下午6:24:09 
* @修改人: 
 * @修改时间: 
 * @修改内容:
 * @版本: V1.0
 * @版权:Copyright ©  All rights reserved.
* @param <T>
 */
public abstract class CommonAdapter<T> extends BaseAdapter
{
	protected LayoutInflater mInflater;
	protected Context mContext;
	protected List<T> mDatas;
	protected final int mItemLayoutId;

	public CommonAdapter(Context context, List<T> mDatas, int itemLayoutId)
	{
		this.mContext = context;
		this.mInflater = LayoutInflater.from(mContext);
		this.mDatas = mDatas;
		this.mItemLayoutId = itemLayoutId;
	}

	@Override
	public int getCount()
	{
		return mDatas.size();
	}

	@Override
	public T getItem(int position)
	{
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		final ViewHolder viewHolder = getViewHolder(position, convertView,
				parent);
		convert(viewHolder, getItem(position));
		return viewHolder.getConvertView();

	}

	public abstract void convert(ViewHolder helper, T item);

	private ViewHolder getViewHolder(int position, View convertView,
			ViewGroup parent)
	{
//	    if (convertView == null)
//            { 
                    return new ViewHolder(mContext, parent, mItemLayoutId, position,convertView);
//            }else{
//                return new ViewHolder(mContext, parent, mItemLayoutId, position,convertView);
////                return (ViewHolder) convertView.getTag();
//            } 
	    
//		return ViewHolder.get(mContext, convertView, parent, mItemLayoutId,
//				position);
	}

}
