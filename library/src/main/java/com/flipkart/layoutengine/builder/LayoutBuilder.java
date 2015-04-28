package com.flipkart.layoutengine.builder;

import android.view.View;
import android.view.ViewGroup;

import com.flipkart.layoutengine.ParserContext;
import com.flipkart.layoutengine.parser.LayoutHandler;
import com.flipkart.layoutengine.toolbox.BitmapLoader;
import com.flipkart.layoutengine.view.ProteusView;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * @author  kirankumar
 */
public interface LayoutBuilder {
    void registerHandler(String viewType, LayoutHandler<View> handler);

    void unregisterHandler(String viewType);

    void unregisterAllHandlers();

    LayoutHandler getHandler(String viewType);

    boolean handleAttribute(LayoutHandler<View> handler, ParserContext context, String attribute, JsonObject layoutJsonObject, JsonElement modelData, View view, ViewGroup parent, int index);

    ProteusView build(ViewGroup parent, JsonObject layout, JsonObject data);

    LayoutBuilderCallback getListener();

    void setListener(LayoutBuilderCallback listener);

    BitmapLoader getNetworkDrawableHelper();

    void setBitmapLoader(BitmapLoader bitmapLoader);

    boolean isSynchronousRendering();

    void setSynchronousRendering(boolean isSynchronousRendering);
}
