Deleting keys using Redis Repositories is not atomic and can therefore cause the Redis cache to get into an unexpected state when the Redis server is under high load, and particularly when secondary indexes are being used. What I have observed is that a hash key's indexes can be deleted, and then the delete of the hash key itself fails for whatever reason (possibly a timeout). It is then difficult to programatically delete the hash key because there are now no indexes pointing to it.

In this example, I have saved three Students to the repository using the the POST endpoint. Here is the state after doing so.
![image](https://github.com/lilyt20/redihashdemo/assets/137898840/4b4d5077-16b3-4d88-9a32-bf34c95e56ad)

One Student is in grade 11.
![image](https://github.com/lilyt20/redihashdemo/assets/137898840/b21d564f-b45b-40f8-961f-582a8777cafd)
![image](https://github.com/lilyt20/redihashdemo/assets/137898840/829686cc-9b76-4c38-b634-ac865e6fc61f)

Now. if I delete all students for which the gradeLevel is 11, and the delete fails partway through, I am left with the hash key **{student}:125**, but **{student}:125:idx** and **{student}:gradeLevel:11** have been deleted, and **125** is no longer a memeber of **{student}**.

![image](https://github.com/lilyt20/redihashdemo/assets/137898840/9146afba-b388-425a-9373-170ed03f43f0)
