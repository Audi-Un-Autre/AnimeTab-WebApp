
export class SignUp{
    private email:string;
    private username:string;
    private password:string;
    private role:string;

    constructor(email: string, username: string, password: string, role:string = "LIMITED"){
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    getEmail():string{
        return this.email;
    }

    getUsername():string{
        return this.username;
    }

    getPassword():string{
        return this.password;
    }

    getRole():string{
        return this.role;
    }
}