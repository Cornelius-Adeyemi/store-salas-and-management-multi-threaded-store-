# store-salas-and-management-multi-threaded-store-
In this version of the store sales and management,  I implemented multi-threaded allowing multiple customers to purchase from the while also preventing various problem associated associated with multithreading like race condition and deadlock.
I was able to prevent this problem by using this synchronized block to lock the shared resources which is the store object
