package com.pax.rowen.googlemark.http.protocol;

import com.pax.rowen.googlemark.domain.AppInfo;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * 首页网络数据解析
 *
 */
public class HomeProtocol extends BaseProtocol<ArrayList<AppInfo>> {

	@Override
	public String getKey() {
		return "home";
	}

	@Override
	public String getParams() {
		return "";// 如果没有参数,就传空串,不要传null
	}

	@Override
	public ArrayList<AppInfo> parseData(String result) {
		// Gson, JsonObject
		// 使用JsonObject解析方式: 如果遇到{},就是JsonObject;如果遇到[], 就是JsonArray
		try {
			JSONObject jo = new JSONObject(result);

			// 解析应用列表数据
			JSONArray ja = jo.getJSONArray("list");
			ArrayList<AppInfo> appInfoList = new ArrayList<AppInfo>();
			for (int i = 0; i < ja.length(); i++) {
				JSONObject jo1 = ja.getJSONObject(i);

				AppInfo info = new AppInfo();
				info.des = jo1.getString("des");
				info.downloadUrl = jo1.getString("downloadUrl");
				info.iconUrl = jo1.getString("iconUrl");
				info.id = jo1.getString("id");
				info.name = jo1.getString("name");
				info.packageName = jo1.getString("packageName");
				info.size = jo1.getLong("size");
				info.stars = (float) jo1.getDouble("stars");

				appInfoList.add(info);
			}

			// 初始化轮播条的数据
			JSONArray ja1 = jo.getJSONArray("picture");
			ArrayList<String> pictures = new ArrayList<String>();
			for (int i = 0; i < ja1.length(); i++) {
				String pic = ja1.getString(i);
				pictures.add(pic);
			}

			return appInfoList;

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

}
