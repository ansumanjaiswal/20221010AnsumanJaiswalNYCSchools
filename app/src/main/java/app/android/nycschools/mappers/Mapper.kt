package app.android.nycschools.mappers

interface Mapper<T, R> {

    fun map(params: T): R
}