package com.example.mathstudy.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mathstudy.R;
import com.example.mathstudy.activities.PdfReader;
import com.example.mathstudy.roomComponents.entities.Document;

import java.util.ArrayList;

public class DocumentsMenuAdapter extends RecyclerView.Adapter<DocumentsMenuAdapter.ViewHolder>{

    private ArrayList<Document> mDocuments = new ArrayList<>();

    public DocumentsMenuAdapter(ArrayList<Document> documents){
        this.mDocuments = documents;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.document_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getDocTitle().setText(mDocuments.get(position).getTitle());
        holder.getDocSubTitle().setText(mDocuments.get(position).getSubTitle());
        holder.getItemCard().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PdfReader.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDocuments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView itemCard;
        private AppCompatImageView docIcon;
        private TextView docTitle;
        private TextView docSubTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemCard = (CardView) itemView.findViewById(R.id.itemCard);
            docIcon = (AppCompatImageView) itemView.findViewById(R.id.documentIcon);
            docTitle = (TextView) itemView.findViewById(R.id.documentTitle);
            docSubTitle = (TextView) itemView.findViewById(R.id.documentSubtitle);
        }

        public CardView getItemCard() {
            return itemCard;
        }

        public void setItemCard(CardView itemCard) {
            this.itemCard = itemCard;
        }

        public AppCompatImageView getDocIcon() {
            return docIcon;
        }

        public void setDocIcon(AppCompatImageView docIcon) {
            this.docIcon = docIcon;
        }

        public TextView getDocTitle() {
            return docTitle;
        }

        public void setDocTitle(TextView docTitle) {
            this.docTitle = docTitle;
        }

        public TextView getDocSubTitle() {
            return docSubTitle;
        }

        public void setDocSubTitle(TextView docSubTitle) {
            this.docSubTitle = docSubTitle;
        }
    }
}
