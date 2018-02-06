package com.watchlist.data.entity.mapper

import java.util.ArrayList

/**
 * Created by alexanderpereu on 25.01.2018.
 */
abstract class EntryEntityMapper<Model, Entity> {

    abstract fun transform(entity: Entity?): Model?

    fun transform(collection: Collection<Entity>): ArrayList<Model> {
        val list = ArrayList<Model>()
        var model: Model?
        for (entity in collection) {
            model = transform(entity)
            if (model != null) {
                list.add(model)
            }
        }
        return list
    }
}