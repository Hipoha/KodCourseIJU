package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum() {
        forumUserList.add(new ForumUser(974543, "Bing", 'M', 1987, 6, 12, 3));
        forumUserList.add(new ForumUser(948367, "Kurator", 'M', 1999, 8, 23, 86));
        forumUserList.add(new ForumUser(328742, "Pando", 'M', 1996, 7, 1, 0));
        forumUserList.add(new ForumUser(213874, "Miki", 'M', 1943, 12, 6, 243));
        forumUserList.add(new ForumUser(534725, "Mini", 'F', 2009, 6, 9, 123));
        forumUserList.add(new ForumUser(123875, "Łukasz", 'M', 2002, 4, 29, 43));
        forumUserList.add(new ForumUser(873415, "Dino", 'M', 1997, 11, 15, 436));
        forumUserList.add(new ForumUser(239855, "Kicek", 'M', 1997, 11, 16, 654));
        forumUserList.add(new ForumUser(983469, "Rózia", 'F', 1997, 11, 17, 24));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUserList);
    }

}