class Solution {
public:
    vector<int> findOrder(int numCourses, vector<pair<int, int>>& prerequisites) {
        vector<vector<int>> graph(numCourses,vector<int>(0));
        vector<int>indegree(numCourses,0);
        vector<int> res;
        for(auto a:prerequisites){
            graph[a.second].push_back(a.first);
            ++indegree[a.first];
        }
        queue<int> que;
        for(int i=0;i<numCourses;++i){
            if(indegree[i]==0){
                que.push(i);
            }
        }
        while(!que.empty()){
            int b=que.front();
            res.push_back(b);
            que.pop();
            for(auto c:graph[b]){
                --indegree[c];
                if(indegree[c]==0){
                    que.push(c);
                }
            }
        }
       if (res.size() != numCourses) res.clear();
       // if there is a circl in these graph then call the clear function to delete the memory!!
        return res;
    }
};
