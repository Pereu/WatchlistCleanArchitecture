package com.watchlist.domain.model



class Item {

    val MovieId = 0
    val Title = ""
    val Subtitle = ""
    val Rated  = 0
    val Rating = 0.0
    val RatingCount: Int = 0
    val ProductionYear: Int = 0
    val savedCount: Int? = null
    val Trailer: String? = null
    val ShowtimesStrList: List<String>? = null
    val Duration: String? = null
    val Backdrops: ArrayList<BackdropImages> = arrayListOf()
    val Posters: ArrayList<PosterImages> = arrayListOf()
    val Backdrop = ""
//    @SerializedName("Posters")
//    @Expose
//    private val posters: List<Poster>? = null
//    @SerializedName("Poster")
//    @Expose
//    private val poster: String? = null
//    @SerializedName("Backdrop")
//    @Expose
//    private val backdrop: String? = null
//    @SerializedName("CommentUserName")
//    @Expose
//    private val commentUserName: String? = null
//    @SerializedName("CommentText")
//    @Expose
//    private val commentText: String? = null
//    @SerializedName("HasDirectVideoLink")
//    @Expose
//    private val hasDirectVideoLink: Boolean? = null
//    @SerializedName("IsUpcoming")
//    @Expose
//    private val isUpcoming: Boolean? = null
//    @SerializedName("IsShowed")
//    @Expose
//    private val isShowed: Boolean? = null
//    @SerializedName("IsLive")
//    @Expose
//    private val isLive: Boolean? = null
//    @SerializedName("Showtime")
//    @Expose
//    private val showtime: Any? = null
//    @SerializedName("SocialData")
//    @Expose
//    private val socialData: Any? = null
}