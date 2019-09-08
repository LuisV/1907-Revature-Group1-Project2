export class User {
    id: number;
    username: string;
    password: string;
    banned: number;
    role: number;

    constructor( id: number,
                 username: string,
                 password: string,
                 banned: number,
                 role: number,
    ) {
this.id = id;
this.username = username;
this.password = password;
this.banned = banned;
this.role = role;

}

}
