package school.sorokin.javacore.oop.exam;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Publication> publications;

    public Library() {
        this.publications = new ArrayList<>();
    }

    public void addPublication(Publication pub){
        if (pub != null){
            publications.add(pub);
            Publication.incrementPublicationCount();
        }

    }

    public void listPublications(){

        //для построчного вывода
        for (Publication publication : publications){
            System.out.println(publication);
        }
    }

    public void searchByAuthor(String author){
        if (author == null) return;

        for (Publication publication : publications){
            if (publication.getAuthor().equals(author)){
                System.out.println(publication);
            }
        }
    }
}
