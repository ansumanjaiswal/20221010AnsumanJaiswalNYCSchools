package app.android.nycschools.useCases

import app.android.nycschools.models.SchoolViewData

interface UseCase<T> {

    suspend fun getData(): T
}