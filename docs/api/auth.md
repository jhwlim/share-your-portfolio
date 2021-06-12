### Access Token 재발급
method|path|description
---|---|---
GET|/auth/refresh|쿠키에 저장된 refresh token을 사용하여 access token을 재발급한다.

request
- header :
    ```json
    Content-type: "application/json"
    ```
    
response
- data :
    ```json
    {
        token: string
    }
    ```

error
- data :
    ```json
    {
        statusCode: number,
        status: string,
        message: string
    }
    ```

    statusCode|Description
    :-:|:--
    401|access token이나 refresh token 유효성 검사를 통과하지 못한 경우