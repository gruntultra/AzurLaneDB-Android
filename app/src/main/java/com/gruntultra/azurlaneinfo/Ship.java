package com.gruntultra.azurlaneinfo;


import com.google.gson.annotations.SerializedName;


import java.io.Serializable;
import java.util.ArrayList;

public class Ship implements Serializable {
    private String wikiUrl;
    private String id;
    private Names names;
    @SerializedName("class")
    private String mClass;
    private String nationality;
    private String hullType;
    private String thumbnail;
    private int stars;
    private Stats stats;
    private ArrayList<Slots> slots;
    private Object enhanceValue;
    private Object scrapValue;
    private ArrayList<Skills> skills;
    private ArrayList<Skins> skins;
    private ArrayList<GalleryItem> gallery;
    private ArrayList<ArrayList<String>> limitBreaks;
    private FleetTech fleetTech;
    private boolean retrofit;
    private String retrofitId;
    private RetrofitProjects retrofitProjects;
    private Construction construction;
    private ObtainedFrom obtainedFrom;
    private Misc misc;


    public Ship(String wikiUrl, String id, Names names, String mClass, String nationality,
                String hullType, String thumbnail, int stars, Stats stats, ArrayList<Slots> slots,
                Object enhanceValue, Object scrapValue, ArrayList<Skills> skills, ArrayList<Skins> skins,
                ArrayList<GalleryItem> gallery, ArrayList<ArrayList<String>> limitBreaks, FleetTech fleetTech, boolean retrofit,
                String retrofitId, RetrofitProjects retrofitProjects, Construction construction,
                ObtainedFrom obtainedFrom, Misc misc) {
        this.wikiUrl = wikiUrl;
        this.id = id;
        this.names = names;
        this.mClass = mClass;
        this.nationality = nationality;
        this.hullType = hullType;
        this.thumbnail = thumbnail;
        this.stars = stars;
        this.stats = stats;
        this.slots = slots;
        if (enhanceValue instanceof String) {
            this.enhanceValue = enhanceValue.toString();
        } else {
            this.enhanceValue = (EnhanceValue) enhanceValue;
        }
        if (scrapValue instanceof String) {
            this.scrapValue = scrapValue.toString();
        } else {
            this.scrapValue = (ScrapValue) scrapValue;
        }
        this.skills = skills;
        this.skins = skins;
        this.gallery = gallery;
        this.limitBreaks = limitBreaks;
        this.fleetTech = fleetTech;
        this.retrofit = retrofit;
        this.retrofitId = retrofitId;
        this.retrofitProjects = retrofitProjects;
        this.construction = construction;
        this.obtainedFrom = obtainedFrom;
        this.misc = misc;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }

    public String getId() {
        return getId();
    }

    public Names getNames() {
        return names;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public int getStars() {
        return stars;
    }

    public String getHullType() {
        return hullType;
    }

    public ArrayList<GalleryItem> getGallery() {
        return gallery;
    }

    public ArrayList<Skins> getSkins() {
        return skins;
    }

    public Stats getStats() {
        return stats;
    }

    public ArrayList<Skills> getSkills() {
        return skills;
    }

    public String getNationality() {
        return nationality;
    }
}

class Names implements Serializable {
    private String code;
    private String en;
    private String cn;
    private String jp;
    private String kr;

    public Names(String code, String en, String cn, String jp, String kr) {
        this.code = code;
        this.en = en;
        this.cn = cn;
        this.jp = jp;
        this.kr = kr;
    }

    public String getCode() {
        return code;
    }
    public String getEn() {
        return en;
    }
    public String getCn() {
        return cn;
    }
    public String getjp() {
        return jp;
    }
    public String getKr() {
        return kr;
    }

}

//class Stars implements Serializable{
//    private String stars;
//    private int value;
//
//    public Stars(String stars, int value) {
//        this.stars = stars;
//        this.value = value;
//    }
//
//    public String getStars() {
//        return stars;
//    }
//    public int getValue() {
//        return value;
//    }
//}

class Stats implements Serializable{
    private StatsV baseStats;
    private StatsV level100;
    private StatsV level120;
    private StatsV level100Retrofit;
    private StatsV level120Retrofit;

    public Stats(StatsV baseStats, StatsV level100, StatsV level120, StatsV level100Retrofit,
                 StatsV level120Retrofit) {
        this.baseStats = baseStats;
        this.level100 = level100;
        this.level120 = level120;
        this.level100Retrofit = level100Retrofit;
        this.level120Retrofit = level120Retrofit;
    }

    public StatsV getBaseStats() {
        return baseStats;
    }
    public StatsV getLevel100() {
        return level100;
    }
    public StatsV getLevel120() {
        return level120;
    }

    public StatsV getLevel100Retrofit() {
        return level100Retrofit;
    }
    public StatsV getLevel120Retrofit() {
        return level120Retrofit;
    }
}

class StatsV implements Serializable {
    private String health;
    private String armor;
    private String reload;
    private String luck;
    private String firepower;
    private String torpedo;
    private String evasion;
    private String speed;
    private String antiair;
    private String aviation;
    private String oilConsumption;
    private String accuracy;
    private String antisubmarineWarfare;
    private String oxygen;
    private String ammunition;
    private String huntingRange;

    public StatsV(String health, String armor, String reload, String luck, String firepower,
                  String torpedo, String evasion, String speed, String antiair,
                  String aviation, String oilConsumption, String accuracy,
                  String antisubmarineWarfare, String oxygen, String ammunition,
                  String huntingRange) {
        this.health = health;
        this.armor = armor;
        this.reload = reload;
        this.luck = luck;
        this.firepower = firepower;
        this.torpedo = torpedo;
        this.evasion = evasion;
        this.speed = speed;
        this.antiair = antiair;
        this.aviation = aviation;
        this.oilConsumption = oilConsumption;
        this.accuracy = accuracy;
        this.antisubmarineWarfare = antisubmarineWarfare;
        this.oxygen = oxygen;
        this.ammunition = ammunition;
        this.huntingRange = huntingRange;
    }

    public String getHealth() {
        return health;
    }
    public String getArmor() {
        return armor;
    }
    public String getReload() {
        return reload;
    }
    public String getLuck() {
        return luck;
    }
    public String getFirepower() {
        return firepower;
    }
    public String getTorpedo() {
        return torpedo;
    }
    public String getEvasion() {
        return evasion;
    }
    public String getSpeed() {
        return speed;
    }
    public String getAntiair() {
        return antiair;
    }
    public String getAviation() {
        return aviation;
    }
    public String getOilConsumption() {
        return oilConsumption;
    }
    public String getAccuracy() {
        return accuracy;
    }
    public String getAntisubmarineWarfare() {
        return antisubmarineWarfare;
    }
    public String getOxygen() {
        return oxygen;
    }
    public String getAmmunition() {
        return ammunition;
    }
    public String getHuntingRange() {
        return huntingRange;
    }
}

/*class Slots implements Serializable {
    private SlotsI first;
    private SlotsI second;
    private SlotsI third;

    public Slots(SlotsI first, SlotsI second, SlotsI third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public SlotsI getFirst() {
        return first;
    }
    public SlotsI getSecond() {
        return second;
    }
    public SlotsI getThird() {
        return third;
    }
}*/

class Slots implements Serializable {
    private String type;
    private int minEfficiency;
    private int maxEfficiency;
    private int max;

    public Slots(String type, int minEfficiency, int maxEfficiency, int max) {
        this.type = type;
        this.max = max;
        this.minEfficiency = minEfficiency;
        this.maxEfficiency = maxEfficiency;
    }

    public String getType() {
        return type;
    }
    public int getMinEfficiency() {
        return minEfficiency;
    }
    public int getMaxEfficiency() {
        return maxEfficiency;
    }
    public int getMax() { return max;}
}

class EnhanceValue implements Serializable {
    private String firepower;
    private String torpedo;
    private String aviation;
    private String reload;

    public EnhanceValue(String firepower, String torpedo, String aviation, String reload) {
        this.firepower = firepower;
        this.torpedo = torpedo;
        this.aviation = aviation;
        this.reload = reload;
    }

}

class ScrapValue implements Serializable {
    private int coin;
    private int oil;
    private int medal;

    public ScrapValue(int coin, int oil, int medal) {
        this.coin = coin;
        this.oil = oil;
        this.medal = medal;
    }
}

class Skills implements Serializable {
    private String icon;
    private Names names;
    private String description;
    private String color;

    public Skills(String icon, Names names, String description, String color) {
        this.icon = icon;
        this.names = names;
        this.description = description;
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }
    public Names getNames() {
        return names;
    }
    public String getDescription() {
        return description;
    }
    public String getColor() {
        return color;
    }
}

class FleetTech implements Serializable {
    private StatsBonus statsBonus;
    private TechPoints techPoints;

    public FleetTech(StatsBonus statsBonus, TechPoints techPoints) {
        this.statsBonus = statsBonus;
        this.techPoints = techPoints;
    }
}

class StatsBonus implements Serializable {
    private Collection collection;
    public StatsBonus(Collection collection) {
        this.collection = collection;
    }
}

class Collection implements Serializable {
    private ArrayList<String> applicable;
    private String stats;
    private String bonus;

    public Collection(ArrayList<String> applicable, String stats, String bonus) {
        this.applicable = applicable;
        this.stats = stats;
        this.bonus = bonus;
    }
}

class TechPoints implements Serializable {
    private int collection;
    private int maxLimitBreak;
    private int maxLevel;
    private int total;

    public TechPoints(int collection, int maxLimitBreak, int maxLevel, int total) {
        this.collection = collection;
        this.maxLimitBreak = maxLimitBreak;
        this.maxLevel = maxLevel;
        this.total = total;
    }
}

class Construction implements Serializable {
    private String constructionTime;
    private AvailableIn availableIn;

    public Construction(String constructionTime, AvailableIn availableIn) {
        this.constructionTime = constructionTime;
        this.availableIn = availableIn;
    }
}

class AvailableIn implements Serializable {
    private boolean light;
    private boolean heavy;
    private boolean aviation;
    private boolean limited;
    private boolean exchange;

    public AvailableIn (boolean light, boolean heavy, boolean aviation,
                        boolean limited, boolean exchange) {
        this.light = light;
        this.heavy = heavy;
        this.aviation = aviation;
        this.limited = limited;
        this.exchange = exchange;
    }
}

class ObtainedFrom implements Serializable {
    private String obtainedFrom;
    private Object fromMaps;

    public ObtainedFrom(String obtainedFrom, Object fromMaps) {
        this.obtainedFrom = obtainedFrom;
        if (fromMaps instanceof String) {
            this.fromMaps = fromMaps.toString();
        } else {
            this.fromMaps = (FromMap) fromMaps;
        }

    }
}

class Misc implements Serializable {
    private Artist artist;
    private Artist web;
    private Artist pixiv;
    private Artist twitter;
    private Artist voice;

    public Misc(Artist artist, Artist web, Artist pixiv, Artist twitter, Artist voice) {
        this.artist = artist;
        this.web = web;
        this.pixiv = pixiv;
        this.twitter = twitter;
        this.voice =voice;
    }
}

class Artist implements Serializable{
    private String name;
    private String url;

    public Artist(String name, String url) {
        this.name = name;
        this.url = url;
    }
}

class Skins implements Serializable {
    private String name;
    private String image;
    private String imageCn;
    private String background;
    private String chibi;
    private Info info;

    public Skins(String name, String image, String imageCn, String background,
                 String chibi, Info info) {
        this.name = name;
        this.image = image;
        this.imageCn = imageCn;
        this.background = background;
        this.chibi = chibi;
        this.info = info;
    }

    public String getName() {
        return name;
    }
    public String getImage() {
        return image;
    }
}

class Info implements Serializable {
    private String enClient;
    private String cnClient;
    private String jpClient;
    private String cost;
    private String obtainedFrom;
    private String live2dModel;

    public Info(String enClient, String cnClient, String jpClient, String cost,
                String obtainedFrom, String live2dModel) {
        this.enClient = enClient;
        this.cnClient = cnClient;
        this.jpClient = jpClient;
        this.cost = cost;
        this.obtainedFrom = obtainedFrom;
        this.live2dModel = live2dModel;
    }
}

class GalleryItem implements Serializable {
    private String description;
    private String url;

    public GalleryItem(String description, String url) {
        this.description = description;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}

class RetrofitProjects implements Serializable {
    private String name;
    private ArrayList<String> attributes;
    private ArrayList<String> materials;
    private int coins;
    private int level;
    private int levelBreakLevel;
    private String levelBreakStars; // ★★☆☆☆
    private int recurrence;
    private ArrayList<String> require;

    public RetrofitProjects(String name, ArrayList<String> attributes,
                            ArrayList<String> materials, int coins, int level, int levelBreakLevel,
                            String levelBreakStars, int recurrence, ArrayList<String> require) {
        this.name = name;
        this.attributes =attributes;
        this.materials = materials;
        this.coins = coins;
        this.level = level;
        this.levelBreakLevel = levelBreakLevel;
        this.levelBreakStars = levelBreakStars;
        this.recurrence = recurrence;
        this.require = require;
    }
}


class FromMap implements Serializable {
    private String fromMaps;
    private NodeDetail nodeDetail;

    public FromMap(String fromMaps, NodeDetail nodeDetail) {
        this.fromMaps = fromMaps;
        this.nodeDetail = nodeDetail;
    }
}

class NodeDetail implements Serializable {
    private String name;
    private String note;

    public NodeDetail(String name, String note) {
        this.name = name;
        this.note = note;
    }
}