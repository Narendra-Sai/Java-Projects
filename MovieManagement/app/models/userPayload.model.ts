
export class UserPayload {
  requestId: number;
  requestType: string;
  userid: string;

  constructor(requestId: number, userid: string, requestType: string ) {
    this.requestId = requestId;
    this.userid = userid;
    this.requestType = requestType;
    }

}
