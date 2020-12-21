# Assessment_GovData
API access for getting public department data and display then in UI

## There are two modules <br>
Department List<br>
Department Details

### Department List
It uses View model architecture to connect to a repository. The repository decides whether to fetch the data from the database which in this case is "Room database" or to make an API call via "Retrofit". The view model doesn't know the point of data access, so it fulfils the complete abstract behavior.

### Department Details
Similar to the department list,it uses View model architecture to connect to a repository. The repository decides whether to fetch the data from the database which in this case is "Room database" or to make an API call via "Retrofit". The view model doesn't know the point of data access, so it fulfils the complete abstract behavior. ones it has the data it doesn't make the API call again

## Test Cases (Espresso)
- One test case is to click an item of recycler view and go to the next page.
- go back to the previous page by clicking on a button.





