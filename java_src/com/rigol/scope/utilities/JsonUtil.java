package com.rigol.scope.utilities;

import android.text.TextUtils;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.ResultParam;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class JsonUtil {
    public static String toJson(List<ResultParam> list) throws JSONException {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (ResultParam resultParam : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", resultParam.getMeasType().value1);
            jSONObject.put("srca", resultParam.getSourceA().value1);
            jSONObject.put("srcb", resultParam.getSourceB().value1);
            jSONObject.put("stat", resultParam.getStat());
            jSONObject.put("mode", resultParam.getMode());
            jSONArray.put(jSONObject);
        }
        return jSONArray.toString();
    }

    public static List<ResultParam> getResultParams(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONObject) {
                ResultParam resultParam = new ResultParam();
                JSONObject jSONObject = (JSONObject) obj;
                resultParam.setMeasType(ServiceEnum.getMeasTypeFromValue1(((Integer) jSONObject.get("type")).intValue()));
                resultParam.setSourceA(ServiceEnum.getChanFromValue1(((Integer) jSONObject.get("srca")).intValue()));
                resultParam.setSourceB(ServiceEnum.getChanFromValue1(((Integer) jSONObject.get("srcb")).intValue()));
                if (jSONObject.has("stat")) {
                    resultParam.setStat(((Integer) jSONObject.get("stat")).intValue());
                }
                if (jSONObject.has("mode")) {
                    resultParam.setMode(((Integer) jSONObject.get("mode")).intValue());
                }
                arrayList.add(resultParam);
            }
        }
        return arrayList;
    }
}
