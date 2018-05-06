package top.huhuiyu.myspringboot.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonMessage implements Serializable {
  private static final long serialVersionUID = 5414116991779501076L;
  private static final Logger log = LoggerFactory.getLogger(JsonMessage.class);

  private boolean success = false;
  private String message = "操作失败";
  private Map<String, Object> dataMap = new HashMap<String, Object>();

  public Map<String, Object> getDataMap() {
    return dataMap;
  }

  public void setDataMap(Map<String, Object> dataMap) {
    this.dataMap = dataMap;
  }

  public void putData(String key, Object data) {
    dataMap.put(key, data);
  }

  public void putDatas(Map<String, Object> datas) {
    dataMap.putAll(datas);
  }

  public void clearData() {
    dataMap.clear();
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public JsonMessage() {
    this(false, "操作失败");
  }

  public JsonMessage(boolean success, String message) {
    this.success = success;
    this.message = message;
    dataMap.put("nowTimestamp", new Date().getTime());
  }

  public static JsonMessage getJsonMessage(boolean success, String message, Map<String, Object> dataMap) {
    JsonMessage jsonMessage = new JsonMessage();
    jsonMessage.setSuccess(success);
    jsonMessage.setMessage(message);
    if (dataMap != null && !dataMap.isEmpty()) {
      jsonMessage.putDatas(dataMap);
    }
    return jsonMessage;
  }

  public static JsonMessage getSuccessMessage(String message) {
    return JsonMessage.getJsonMessage(true, message, null);
  }

  public static JsonMessage getSuccessMessage(String message, Map<String, Object> dataMap) {
    return JsonMessage.getJsonMessage(true, message, dataMap);
  }

  public static JsonMessage getFailMessage(String message) {
    return JsonMessage.getJsonMessage(false, message, null);
  }

  public static JsonMessage getFailMessage(Throwable ex) {
    log.error("程序错误。。。", ex);
    return JsonMessage.getJsonMessage(false, "服务器忙，请稍后重试。", null);
  }

  @Override
  public String toString() {
    return "JsonMessage [success=" + success + ", message=" + message + ", dataMap=" + dataMap + "]";
  }

}
