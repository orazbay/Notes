package edu.sdu.kz.baseapplication.data.prefs;

public interface IPreferencesHelper {
    void saveToken(String token);
    void removeToken();
    String getToken();

    void saveId(String id);
    void removeId();
    String getId();



    void saveString(String key, String value);
    String getString(String key);

    void removeKey(String key);

    boolean isAppFirstTimeLaunched();
    void setIsAppFirstTimeLaunched();


}
