package com.example.android.sunshine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

/**
 * Created by KV on 13/6/17.
 */

public class SettingFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }



    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
     addPreferencesFromResource(R.xml.sunshine_pref);

        SharedPreferences sp=getPreferenceScreen().getSharedPreferences();
        Preference preference=findPreference(getString(R.string.unitkey));
      String string=sp.getString(preference.getKey(),"");
        addSummary(preference,string);

    }

    private void addSummary(Preference preference, String string) {
        if(preference instanceof ListPreference)
        {
            ListPreference listPreference=(ListPreference)preference;
            int preindex=listPreference.findIndexOfValue(string);
            if(preindex>=0)
            {
                listPreference.setSummary(listPreference.getEntries()[preindex]);
            }


        }

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference pref=findPreference(key);
        if(pref!=null)
        {

                String value=sharedPreferences.getString(pref.getKey(),"");
                addSummary(pref,value);

        }
    }
}
