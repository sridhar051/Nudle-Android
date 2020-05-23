package com.intern.nudleapp;

public class ProductSpecificationModel {
    private String featureName;
    private  String featureValue;

    public ProductSpecificationModel(String featureName, String featureValue) {
        this.featureName = featureName;
        this.featureValue = featureValue;
    }
    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }

    public String getFeatureValue() {
        return featureValue;
    }

    public String getFeatureName() {
        return featureName;
    }
}
