
export class UserModel {
  id: number;
  name: string;
  userid: string;
  role: string;

  constructor(id: number, name: string, userid: string, role: string) {
    this.id = id;
    this.name = name;
    this.userid = userid;
    this.role = role;
  }

}
