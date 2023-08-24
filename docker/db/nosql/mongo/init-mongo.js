db.createUser(
    {
        user: "user",
        pwd: "password",
        roles: [
            {
                role: "readWrite",
                db: "car-service-nosql-db"
            }
        ]
    }
)