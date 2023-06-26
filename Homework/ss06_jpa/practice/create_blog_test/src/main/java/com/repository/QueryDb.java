package com.repository;


public class QueryDb {
    public static final String SELECT_BLOG_BY_ID = " SELECT blog.idBlog , blog.content , blog.title ,blog.description, author.idAuthor ," +
            " author.name , statusblog.idStatusBlog , statusblog.likeBlog , statusblog.timeCreateBlog\n" +
            ", statusblog.timeViewBlog , statusblog.viewBlog \n" +
            "FROM blog JOIN author ON blog.idAuthor = author.idAuthor\n" +
            "JOIN statusblog ON blog.idStatusBlog = statusblog.idStatusBlog WHERE blog.idBlog = ?;";
    public static String SELECT_MAX_ID_AUTHOR = "SELECT MAX(idAuthor) FROM author;";
    public static String SELECT_MAX_ID_STATUS_BLOG = "SELECT MAX(idStatusBlog) FROM statusblog;";

    public static String SELECT_BLOG_ON_DAY = "SELECT blog.idBlog , blog.content , blog.title ,blog.description, author.idAuthor , author.name , statusblog.idStatusBlog , statusblog.likeBlog , statusblog.timeCreateBlog\n" +
            ", statusblog.timeViewBlog , statusblog.viewBlog \n" +
            "FROM blog JOIN author ON blog.idAuthor = author.idAuthor\n" +
            "JOIN statusblog ON blog.idStatusBlog = statusblog.idStatusBlog WHERE statusblog.timeCreateBlog = curdate();";

    public static String SELECT_BLOG_TOP_VIEW = "SELECT blog.idBlog , blog.content , blog.title ,blog.description, " +
            "author.idAuthor , author.name , statusblog.idStatusBlog , statusblog.likeBlog , statusblog.timeCreateBlog\n" +
            ", statusblog.timeViewBlog , statusblog.viewBlog \n" +
            "FROM blog JOIN author ON blog.idAuthor = author.idAuthor\n" +
            "JOIN statusblog ON blog.idStatusBlog = statusblog.idStatusBlog WHERE " +
            "statusblog.viewBlog IN ( SELECT  MAX(statusblog.viewBlog) FROM statusblog);";

    public static String SELECT_ALL_BLOG  = "SELECT blog.idBlog , blog.content , blog.title ,blog.description, author.idAuthor , author.name , statusblog.idStatusBlog , statusblog.likeBlog , statusblog.timeCreateBlog\n" +
            ", statusblog.timeViewBlog , statusblog.viewBlog \n" +
            "FROM blog JOIN author ON blog.idAuthor = author.idAuthor\n" +
            "JOIN statusblog ON blog.idStatusBlog = statusblog.idStatusBlog";

    public static String ADD_VIEW = "UPDATE statusblog SET statusblog.viewBlog = statusblog.viewBlog + 1 WHERE statusblog.idStatusBlog = ?;";
    public static final String ADD_LIKE = "UPDATE statusblog SET statusblog.likeBlog = statusblog.likeBlog + 1 WHERE statusblog.idStatusBlog = ?;";

}
