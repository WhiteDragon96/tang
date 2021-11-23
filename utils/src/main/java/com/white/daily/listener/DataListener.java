package com.white.daily.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tcs
 * @date Created in 2021-03-19
 */
public class DataListener<T> extends AnalysisEventListener<T> {
    private final List<T> dataList = new ArrayList();

    public DataListener() {
    }
    @Override
    public void invoke(T t, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
    public List<T> getDataList() {
        return this.dataList;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DataListener)) {
            return false;
        } else {
            DataListener<?> other = (DataListener)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (!super.equals(o)) {
                return false;
            } else {
                Object this$dataList = this.getDataList();
                Object other$dataList = other.getDataList();
                if (this$dataList == null) {
                    if (other$dataList != null) {
                        return false;
                    }
                } else if (!this$dataList.equals(other$dataList)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DataListener;
    }

    public int hashCode() {
        int result = super.hashCode();
        Object $dataList = this.getDataList();
        result = result * 59 + ($dataList == null ? 43 : $dataList.hashCode());
        return result;
    }
}
