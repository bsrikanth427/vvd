export class Account {
  constructor(
    public id: string,
    public activated: boolean,
    public authorities: string[],
    public email: string,
    public roles: string[],
    public firstName: string,
    public langKey: string,
    public lastName: string,
    public login: string,
    public imageUrl: string
  ) {}
}
