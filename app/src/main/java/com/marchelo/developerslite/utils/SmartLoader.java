package com.marchelo.developerslite.utils;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

/**
 * @author Oleg Green
 * @since 09.05.16
 */
public abstract class SmartLoader<DataType> extends AsyncTaskLoader<DataType> {
    private DataType mData;

    public SmartLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        if (mData != null && !takeContentChanged()) {
            deliverResult(mData);
        } else {
            forceLoad();
        }
    }

    @Override
    public void deliverResult(DataType data) {
        mData = data;
        super.deliverResult(data);
    }
}