package com.watchlist.domain.model

/**
 * Created by alexanderpereu on 02.03.2018.
 */
class CinemaMovie {

    private var Items: List<Movies> = arrayListOf()

    class Movies {

        private var ActorsList: List<String>? = arrayListOf()

//        @SerializedName("Actors")
//        private var Actors: List<Actor>? = arrayListOf

        private var Director: String? = null

        private var Trailer = ""

        private var Overview = ""

        private var Tags: Array<String>? = null

        private var Released = ""

        private var ReleaseDate = ""

        private var CommentsCount = 0

        private var Type: Int = 0

        private var Id: Long = 0

        private var ExternalId: Long = 0

        private var Width: Int = 0

        private var Height: Int = 0

        private var LoadDataId: String? = null

        private var EntityId = -1L

        private var EntityType = -1

        private var MovieId = -1L

        private var Trailer320Url = ""

        private var Trailer640Url = ""

        var OwnerId = -1L

        private var OwnerLogo = ""

        private var Logo: String? = null

        private var Title = ""

        private var Subtitle = ""

        private var ProductionYear = -1

        private var SavedCount = -1

        private var Rating = -1f

        private var Rated = -1f

        private var IsUpcoming: Boolean = false

        private var RatingCount = -1

        private var Backdrops: List<TrendingImage>? = null

        private var Images: List<TrendingImage>? = null

        private var Posters: List<TrendingImage>? = null

        private var ButtonToShow = 0

        private var CommentUserName = ""

        private var CommentText = ""

        private var SavedPlace = ""

        private var Name: String? = null

        private var Text: String? = null

        private var CollectionId = -1L

        private var FollowersCount = -1

        private var MoviesCount = -1

        private var UserId = -1L

        private var AvatarUrl: String? = null

        var IsFollowed = false

        private var IsAdded = false
    }
}