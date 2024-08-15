using Microsoft.AspNetCore.Mvc;

[Route("api/users")]
public class UserVerifyController : ControllerBase
{
    [HttpGet("{id}/verify")]
    public IActionResult VerifyUser(int id)
    {
        // Temporary implementation
        if (id == 1)
        {
            return Ok();
        }
        else
        {
            return NotFound();
        }
    }
}
