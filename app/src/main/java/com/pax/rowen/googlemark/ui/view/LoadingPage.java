package com.pax.rowen.googlemark.ui.view;

import com.pax.rowen.googlemark.R;
import com.pax.rowen.googlemark.utils.UIUtils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * 根据当前状态来显示不同页面的自定义控件
 * 
 * - 未加载 - 加载中 - 加载失败 - 数据为空 - 加载成功
 * 
 * @author Kevin
 * @date 2015-10-27
 */
public abstract class LoadingPage extends FrameLayout {

	private static final int STATE_LOAD_UNDO = 1;// 未加载
	private static final int STATE_LOAD_LOADING = 2;// 正在加载
	private static final int STATE_LOAD_ERROR = 3;// 加载失败
	private static final int STATE_LOAD_EMPTY = 4;// 数据为空
	private static final int STATE_LOAD_SUCCESS = 5;// 加载成功

	private int mCurrentState = STATE_LOAD_UNDO;// 当前状态

	private View mLoadingPage;
	private View mErrorPage;
	private View mEmptyPage;
	private View mSuccessPage;

	public LoadingPage(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView();
	}

	public LoadingPage(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public LoadingPage(Context context) {
		super(context);
		initView();
	}

	private void initView() {
		// 初始化加载中的布局
		if (mLoadingPage == null) {
			mLoadingPage = UIUtils.inflate(R.layout.page_loading);
			addView(mLoadingPage);// 将加载中的布局添加给当前的帧布局
		}

		// 初始化加载失败布局
		if (mErrorPage == null) {
			mErrorPage = UIUtils.inflate(R.layout.page_error);
			addView(mErrorPage);
		}

		// 初始化数据为空布局
		if (mEmptyPage == null) {
			mEmptyPage = UIUtils.inflate(R.layout.page_empty);
			addView(mEmptyPage);
		}

		showRightPage();
	}
	// 根据当前状态,决定显示哪个布局
	private void showRightPage() {
		// if (mCurrentState == STATE_LOAD_UNDO
		// || mCurrentState == STATE_LOAD_LOADING) {
		// mLoadingPage.setVisibility(View.VISIBLE);
		// } else {
		// mLoadingPage.setVisibility(View.GONE);
		// }
		mLoadingPage
				.setVisibility((mCurrentState == STATE_LOAD_UNDO || mCurrentState == STATE_LOAD_LOADING) ? View.VISIBLE
						: View.GONE);

		mErrorPage
				.setVisibility(mCurrentState == STATE_LOAD_ERROR ? View.VISIBLE
						: View.GONE);

		mEmptyPage
				.setVisibility(mCurrentState == STATE_LOAD_EMPTY ? View.VISIBLE
						: View.GONE);

		if(mCurrentState==STATE_LOAD_SUCCESS&&mSuccessPage==null){
			mSuccessPage=onCreatSuccessView();
			if(mSuccessPage!=null)
			addView(mSuccessPage);
		}

		if (mSuccessPage != null) {
			mSuccessPage
					.setVisibility(mCurrentState == STATE_LOAD_SUCCESS ? View.VISIBLE
							: View.GONE);
		}

	}
	//开始加载数据
	public void loadDate(){
		if(mCurrentState!=STATE_LOAD_LOADING){
			mCurrentState=STATE_LOAD_LOADING;
			new Thread(){
				@Override
				public void run() {
					final ResultState resultState=onLoad();
					//耗时操作后，主线程操作UI
						UIUtils.runOnUiThread(new Runnable() {
							@Override
							public void run() {
								if(resultState!=null) {
									mCurrentState = resultState.getState();//网络加载结束，更新网络状态
									// 根据最新的状态来刷新页面
									showRightPage();
								}
							}
						});
					}
			}.start();
		}
	}

	// 加载成功后显示的布局, 必须由调用者来实现
	public abstract View onCreatSuccessView();

	//加载网络数据，返回值表示请求网络结束后的状态
	protected abstract ResultState onLoad();

	public enum ResultState{
		STATE_SUCCESS(STATE_LOAD_SUCCESS),
		STATE_EMPTY(STATE_LOAD_EMPTY),
		STATE_ERROR(STATE_LOAD_ERROR);

		private int state;
		private ResultState(int state){
			this.state=state;
		}

		public int getState(){
			return state;
		}
	}


//	public static class Person {
//
//		public static Person P1 = new Person(10);
//		public static Person P2 = new Person(12);
//		public static Person P3 = new Person(19);
//
//		public Person(int age) {
//
//		}
//	}

	// public enum Person {
	// P1,P2,P3;
	// }
}
