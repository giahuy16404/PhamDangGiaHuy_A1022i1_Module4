package com.repository;

public class QueryDB {
    public static String FIND_ALL = " SELECT imageoftheday.id, imageoftheday.author, " +
            "imageoftheday.feedback,imageoftheday.likeComment,imageoftheday.startDate," +
            "scoringscale.idSco,scoringscale.name FROM image_day.imageoftheday\n" +
            " JOIN scoringscale ON imageoftheday.idSco = scoringscale.idSco\n" +
            " WHERE imageoftheday.startDate = curdate();";
    public static String FIND_ALL_ScoringScale = " SELECT * FROM image_day.ScoringScale;";
    public static String LIKE_COMMENT = "UPDATE imageoftheday Set  imageoftheday.likeComment = imageoftheday.likeComment + 1 WHERE id = ?;";

//    public static String FIND_ALL = " SELECT imageoftheday.id, imageoftheday.author, imageoftheday.feedback,imageoftheday.likeComment,imageoftheday.startDate,scoringscale.name FROM image_day.imageoftheday\n" +
//            " JOIN scoringscale ON imageoftheday.idSco = scoringscale.idSco\n" +
//            " WHERE imageoftheday.startDate = curdate();";

}
