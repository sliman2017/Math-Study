package com.example.mathstudy.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.example.mathstudy.R;
import com.example.mathstudy.activities.PdfReader;
import com.example.mathstudy.roomComponents.entities.Document;
import com.example.mathstudy.roomComponents.entities.Lesson;
import com.example.mathstudy.roomComponents.entities.Section;

import java.util.ArrayList;

public class SectionsMenuAdapter extends RecyclerView.Adapter<SectionsMenuAdapter.ViewHolder>{

    private ArrayList<Section> mSections = new ArrayList<>();
    private ArrayList<Lesson> mLessons = new ArrayList<>();

    public SectionsMenuAdapter(ArrayList<Section> Sections, ArrayList<Lesson> Lessons){
        this.mSections = Sections;
        this.mLessons = Lessons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.section_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getDocTitle().setText(mSections.get(position).getSectionTitle());
        holder.getDocSubTitle().setText(mSections.get(position).getSectionSubTitle());
        //holder.docIcon.setImageBitmap(mSections.get(position).getPic());
        holder.getItemCard().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillRecyclerLessons(holder.collapsedRecylcer, mLessons);
                int mv = (holder.collapsedRecylcer.getVisibility()==View.GONE)? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(holder.collapsedRecylcer, new AutoTransition());
                holder.collapsedRecylcer.setVisibility(mv);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSections.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView itemCard;
        private AppCompatImageView docIcon;
        private TextView docTitle;
        private TextView docSubTitle;
        private RecyclerView collapsedRecylcer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemCard = (CardView) itemView.findViewById(R.id.itemCard);
            docIcon = (AppCompatImageView) itemView.findViewById(R.id.sectionIcon);
            docTitle = (TextView) itemView.findViewById(R.id.sectionTitle);
            docSubTitle = (TextView) itemView.findViewById(R.id.sectionSubtitle);
            collapsedRecylcer = (RecyclerView) itemView.findViewById(R.id.collapsed_recycler);
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

        public RecyclerView getCollapsedRecylcer() {
            return collapsedRecylcer;
        }

        public void setCollapsedRecylcer(RecyclerView collapsedRecylcer) {
            this.collapsedRecylcer = collapsedRecylcer;
        }
    }

    /**
     * this function will attach the adapter to the recyclerView
     * @param recyclerView this parameter will be the one of these three
     *                     recycler sectionRecycler, t2Recycler or t3Recycler.
     *                     with t means trimester.
     * @param lesson will be the list of Sections for the trimester_1, trimester_2
     *                  or trimester_3 in the chosen Categorie.
     */
    public void fillRecyclerLessons(RecyclerView recyclerView, ArrayList<Lesson> lesson){
        LessonsMenuAdapter adapter = new LessonsMenuAdapter(lesson);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }
}
