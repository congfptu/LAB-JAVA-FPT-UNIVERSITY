/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Country;

/**
 *
 * @author asus
 */
public class Country extends EastAsiaCountries implements Comparable<Country> {
private String countryTerrain;
    public Country() {
    }

    public Country( String countryCode, String countryName, float totalArea,String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }
    public void display(){
        System.out.format("%-10s%-25s%-20f%s\n",getCountryCode(),getCountryName(),
                getTotalArea(),getCountryTerrain());
        
    }

    @Override
    public int compareTo(Country o) {
      return this.getCountryName().compareTo(o.getCountryName());
    }
    
}
