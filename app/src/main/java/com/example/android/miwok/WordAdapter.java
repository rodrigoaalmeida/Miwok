package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;
    /**
     * o segundo parametro não foi utilizado, pois é apenas para um lista de um unico textview
     * como aqui tem mais de um o valor foi setado direto no super da classe pai como 0
     * mas poderia ser outro valor pelo que li, no entanto zero é mais expressivo.
     *
     * @param context pega a classe em atual da aplicacao
     * @param word    pega a lista com o modelo da classe criada.
     */
    public WordAdapter(Activity context, ArrayList<Word> word, int colorResourceId) {
        super(context, 0, word);
        mColorResourceId = colorResourceId;
    }

    /**
     * preenche a view lista com os dados da lista conforme o modelo list_item.xml
     *
     * @param position    pega a posição do item da lista.
     * @param convertView faz o conceito de preenchimento da view reciclada.
     * @param parent      pega a view pai a quem estiver chamando.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //testa se o preenchimento não esta vazio, se tiver preenche com valortes padrão do pai.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //pega a uma posição da lista para preencher as textview
        Word atualWord = getItem(position);

        //pega o textview pelo id e preenche com o valor da posição atual segundo a variavel passada.
        TextView miwokWord = listItemView.findViewById(R.id.text_view_1);
        miwokWord.setText(atualWord.getMiwokTranslation());

        //pega o textview pelo id e preenche com o valor da posição atual segundo a variavel passada
        TextView defaultWord = listItemView.findViewById(R.id.text_view_2);
        defaultWord.setText(atualWord.getDefaultTranslation());

        //pega a imagem no drawable e coloca na vizualizacao
        ImageView imageResourceId = listItemView.findViewById(R.id.image_view);
        //comparação feita para exibir ou não a imagem dependo de ela existir ou não
        //pois no codigo do curso apresentou problema se não tivesse sido feito o controle
        //mas no meu teste rodou sem problema em um zenfone 2 com android 6.0.1
        if (atualWord.hasImage()) {
            //seta a imagem caso exista na lista
            imageResourceId.setImageResource(atualWord.getImageResourceId());
            imageResourceId.setVisibility(View.VISIBLE);
        }else {
            //torna inexisttente no layout caso não esteja em um lista com imagem
            imageResourceId.setVisibility(View.GONE);
        }

        View layoutContainer = listItemView.findViewById(R.id.container_layout);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        layoutContainer.setBackgroundColor(color);


        return listItemView;
    }
}
