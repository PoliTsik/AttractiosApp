package com.despol.attractions;

class AttractionsModel {
    String AttractionName;
    String AttractionCountry;
    String AttractionCity;
    int image;

    public AttractionsModel(String attractionName, String attractionCountry, String attractionCity, int image) {
        AttractionName = attractionName;
        AttractionCountry = attractionCountry;
        AttractionCity = attractionCity;
        this.image = image;
    }

    public String getAttractionName() {
        return AttractionName;
    }

    public String getAttractionCountry() {
        return AttractionCountry;
    }

    public String getAttractionCity() {
        return AttractionCity;
    }

    public int getImage() {
        return image;
    }
}
