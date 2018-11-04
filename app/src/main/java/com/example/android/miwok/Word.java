package com.example.android.miwok;
/**
 *{@link Word} representa o vocabulario com a palavra para o usuario ler.
 * Este tem a traducao para lingua local e Miwok traducao para a palavra.
 */
public class Word {

    private String mMiwokTranslation;
    private String mDefaultTranslation;

    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /**
     * @return mostra a palavra em Miwok
    */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
    * @return mostra a palavra na lingua local
    */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }
}
