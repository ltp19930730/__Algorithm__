class Solution {
public:
    bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
       bool **graph;
       graph= new bool*[numCourses];
       for(int i=0;i<numCourses;i++){
           graph[i]=new bool[numCourses];
           for(int j=0;j<numCourses;j++){
               graph[i][j]=false;
           }
       }
       for(int k=0;k<prerequisites.size();k++){
           int a=prerequisites[k].first;
           int b=prerequisites[k].second;
           if(graph[b][a]){
               return false;
           }else{
               graph[a][b]=true;
               for(int i=0;i<numCourses;i++){
                   if(graph[i][a]){
                       graph[i][b]=true;
                   }
               }
           }
       }
       return true;
    }
};
//too slow because you need to initalize the array.
