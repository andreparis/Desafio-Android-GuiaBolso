package com.example.ttmarparis.desafioguiabolso.ui.list

import com.example.ttmarparis.desafioguiabolso.ui.base.BaseContract

class ListContract {
    interface View: BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadCategorySuccess()
        fun loadAllCategoriesSuccess()
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun loadCategory()
        fun loadAllCategories()
    }
}