# 20221010AnsumanJaiswalNYCSchools

https://user-images.githubusercontent.com/24514530/195235789-93a75586-ee4c-43be-a281-661d3672fd99.mp4

The app fetches data from network to show list of schools in NYC and displays it on a RecyclerView
On click of recycler view item, the app requests network to fetch list of schools with SAT data. It then filters the school specific data and displays on the details screen

Architecture
MVVM with Clean architecture, following single responsibility principle.
View -> ViewModel -> UseCase -> Repository -> DataSource.
Repository could be Remote or Local(if data is cached), and so is tied to the DataSource which again can be Remote/Network or Local.
UseCase can decide on the repository type Remote or Local to provide data to ViewModel.
UseCase also converts network or raw data to view data to provide to ViewModel.
Mappers used to map raw data to view data.

Dependency Injection using Hilt
Netwroking library Retrofit.

Scope of improvements
Data display on UI can be done using DataBinding.
RecyclerViewAdapter could be passed a interface to handle item click, which can then be handled outside the adapter.
We can have Reducers added to viewmodel to implement state-machines which the view could finally respod to.The reducers change states based on data provided by UseCase.
