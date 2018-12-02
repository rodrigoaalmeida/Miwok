package com.example.android.miwok;
/**
 *{@link Word} representa o vocabulario com a palavra para o usuario ler.
 * Este tem a traducao para lingua local e Miwok traducao para a palavra.
 */
public class Word {

    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mSongResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * contrutor sem imagem
     * @param defaultTranslation traducao local.
     * @param miwokTranslation traducao na lingua Miwok.
     * @param songResourceId audio com a pronuncia
     */
    public Word(String defaultTranslation, String miwokTranslation, int songResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mSongResourceId = songResourceId;
    }

    /**
     * construtor com a imagem
     * @param defaultTranslation traducao local.
     * @param miwokTranslation traducao na lingua Miwok.
     * @param imageResourceId imagem para melhor associacao da traducao.
     * @param songResourceId audio com a pronuncia
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int songResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mSongResourceId = songResourceId;
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

    /**
     * @return retorna o local da imagem para ser carregado na excucao
     */
    public int getImageResourceId(){
        return mImageResourceId;
    }

    /**
     * retorna se ha imagem atribuida na posição da lista para o WordAdapter
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * retorna o audio da pronuncia
     */
    public int getmSongResourceId() {
        return mSongResourceId;
    }
}
