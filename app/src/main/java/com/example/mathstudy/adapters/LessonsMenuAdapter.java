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
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.example.mathstudy.R;
import com.example.mathstudy.activities.Documents;
import com.example.mathstudy.roomComponents.entities.Document;
import com.example.mathstudy.roomComponents.entities.Lesson;
import com.example.mathstudy.roomComponents.entities.Section;

import java.util.ArrayList;

public class LessonsMenuAdapter extends RecyclerView.Adapter<LessonsMenuAdapter.ViewHolder>{

    private ArrayList<Lesson> mLessons = new ArrayList<>();

    public LessonsMenuAdapter(ArrayList<Lesson> Sections){
        this.mLessons = Sections;
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
        holder.getDocTitle().setText(mLessons.get(position).getLessonTitle());
        holder.getDocSubTitle().setText(mLessons.get(position).getLessonSubTitle());
        //holder.docIcon.setImageBitmap(mLessons.get(position).getPic());
        holder.getItemCard().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Documents.class);
                intent.putExtra("Section_id", mLessons.get(position).getIdSection());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mLessons.size();
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
